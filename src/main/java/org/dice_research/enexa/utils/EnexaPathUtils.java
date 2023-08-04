package org.dice_research.enexa.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class can be helpful to translate paths from the ENEXA meta data graph
 * into their local representation and vice versa.
 * 
 * @author Michael R&ouml;der (michael.roeder@uni-paderborn.de)
 *
 */
public class EnexaPathUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnexaPathUtils.class);

    /**
     * Prefix of locations in the ENEXA meta data graph expressing a location that
     * needs to be translated.
     */
    public static final String SHARED_DIR_PREFIX = "enexa-dir://";

    /**
     * Translate the given ENEXA path into a local path using the given shared
     * directory path.
     * 
     * @param enexaPath the path mentioned in the ENEXA meta data graph that should
     *                  be translated.
     * @param sharedDir the absolute path to the shared directory in the local file
     *                  system.
     * @return the absolute local path to the file.
     */
    public static String translateEnexa2LocalPath(String enexaPath, String sharedDir) {
        return getCheckedShared(sharedDir) + enexaPath.substring(SHARED_DIR_PREFIX.length());
    }

    /**
     * Translate the given local file into an ENEXA path using the given shared
     * directory path.
     * 
     * @param localFile the local file that should be translated.
     * @param sharedDir the absolute path to the shared directory in the local file
     *                  system.
     * @return the path of the given file ready to be used in the ENEXA meta data
     *         graph or {@code null} if the given file is not in the given shared
     *         directory.
     */
    public static String translateLocal2EnexaPath(File localFile, String sharedDir) {
        return translateLocal2EnexaPath(localFile.getAbsolutePath(), sharedDir);
    }

    /**
     * Translate the given local path into an ENEXA path using the given shared
     * directory path.
     * 
     * @param localFile the local path that should be translated.
     * @param sharedDir the absolute path to the shared directory in the local file
     *                  system.
     * @return the path of the given file ready to be used in the ENEXA meta data
     *         graph or {@code null} if the given local path is not in the given
     *         shared directory.
     */
//    @CheckForNull
    public static String translateLocal2EnexaPath(String localPath, String sharedDir) {
        String shared = getCheckedShared(sharedDir);
        if (!localPath.startsWith(shared)) {
            LOGGER.error("The given local path {} is not in the shared directory {}. Returning null.", localPath,
                    sharedDir);
            return null;
        }
        return SHARED_DIR_PREFIX + localPath.substring(shared.length());
    }

    /**
     * Internal method that should make sure that the given shared path is correct.
     * 
     * @param sharedDir the absolute path to the shared directory in the local file
     *                  system.
     * @return an updated version if a changes ot the path were necessary.
     */
    protected static String getCheckedShared(String sharedDir) {
        return sharedDir.endsWith(File.separator) ? sharedDir : (sharedDir + File.separator);
    }
}
