package org.jscep.util;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.EntropySourceProvider;
import org.bouncycastle.crypto.fips.FipsDRBG;
import org.bouncycastle.crypto.util.BasicEntropySourceProvider;

import java.nio.charset.Charset;
import java.security.SecureRandom;

public class SecureRandomUtils {
    public static void setDefaultSecureRandom() {
        EntropySourceProvider entSource = new BasicEntropySourceProvider(new SecureRandom(), true);
        FipsDRBG.Builder drgbBldr = FipsDRBG.SHA512.fromEntropySource(entSource)
                .setSecurityStrength(256)
                .setEntropyBitsRequired(256);
        CryptoServicesRegistrar.setSecureRandom(drgbBldr.build(StringUtils.getBytes("number only used once", Charset.defaultCharset()), true));
    }

}
