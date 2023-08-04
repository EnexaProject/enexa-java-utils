package org.dice_research.enexa.utils;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class EnexaPathUtilsTest {

    @Test
    public void testLocal2EnexaPath() {
        File localFile = new File("/enexa/application1/experiment2/file3");
        String sharedDir = "/enexa";
        Assert.assertEquals("enexa-dir://application1/experiment2/file3",
                EnexaPathUtils.translateLocal2EnexaPath(localFile, sharedDir));

        sharedDir = "/enexa/";
        Assert.assertEquals("enexa-dir://application1/experiment2/file3",
                EnexaPathUtils.translateLocal2EnexaPath(localFile, sharedDir));

        localFile = new File("/application1/experiment2/file3");
        Assert.assertNull(EnexaPathUtils.translateLocal2EnexaPath(localFile, sharedDir));
    }

    @Test
    public void testEnexa2LocalPath() {
        String enexaPath = "enexa-dir://application1/experiment2/file3";
        String sharedDir = "/enexa";
        Assert.assertEquals("/enexa/application1/experiment2/file3",
                EnexaPathUtils.translateEnexa2LocalPath(enexaPath, sharedDir));

        sharedDir = "/enexa/";
        Assert.assertEquals("/enexa/application1/experiment2/file3",
                EnexaPathUtils.translateEnexa2LocalPath(enexaPath, sharedDir));
    }
}
