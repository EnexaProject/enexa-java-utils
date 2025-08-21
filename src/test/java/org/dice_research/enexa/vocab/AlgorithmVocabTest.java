package org.dice_research.enexa.vocab;

import java.io.File;
import java.net.MalformedURLException;

import org.dice_research.rdf.test.ModelComparisonHelper;
import org.dice_research.rdf.test.VocabularyClassTestHelper;
import org.junit.Test;

public class AlgorithmVocabTest {

    @Test
    public void test() throws MalformedURLException, AssertionError {
        VocabularyClassTestHelper.runTest(ModelComparisonHelper.loadModel((new File("algorithm.ttl")).toURI().toURL()),
                Algorithm.class, Algorithm.getURI());
    }
}
