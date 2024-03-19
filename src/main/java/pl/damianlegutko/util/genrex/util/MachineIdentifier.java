package pl.damianlegutko.util.genrex.util;

import pl.damianlegutko.util.genrex.exception.GenRexRuntimeException;

import java.net.NetworkInterface;
import java.util.Enumeration;

import static java.net.NetworkInterface.getNetworkInterfaces;
import static java.util.Objects.nonNull;

public class MachineIdentifier {
    public static long getMachineIdentifier() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                byte[] mac = networkInterfaces.nextElement()
                        .getHardwareAddress();

                if (nonNull(mac)) {
                    long id = 0;

                    for (byte b : mac) {
                        id <<= 8;
                        id |= (b & 0xFF);
                    }

                    return id;
                }
            }
        } catch (Exception e) {
            throw new GenRexRuntimeException(e);
        }

        throw new GenRexRuntimeException("Unhandled error. Cannot get machine ID.");
    }
}