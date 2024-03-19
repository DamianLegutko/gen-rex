package pl.damianlegutko.util.genrex.field.id;

import pl.damianlegutko.util.genrex.base.GRexField;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static pl.damianlegutko.util.genrex.util.MachineIdentifier.getMachineIdentifier;

public class GRexSnowflakeID extends GRexField<Long> {
    private long lastTimestamp = -1L;
    private long sequence = 0L;

    private final long twepoch = 1288834974657L;

    private final long workerIdBits = 5L;
    private final long maxWorkerId = ~(-1L << workerIdBits);
    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits;
    private final long sequenceMask = ~(-1L << sequenceBits);

    private final long workerId;

    public GRexSnowflakeID(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }

        this.workerId = workerId;
    }

    public GRexSnowflakeID() {
        this(getMachineIdentifier());
    }

    @Override
    protected Long generateField() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;

            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return currentTimeMillis();
    }
}
