package org.dice_research.enexa.vocab;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.jena.rdf.model.Model;
import org.dice_research.rdf.test.ModelComparisonHelper;
import org.dice_research.rdf.test.VocabularyClassTestHelper;
import org.junit.Assert;
import org.junit.Test;

public class ENEXAVocabTest {

    @Test
    public void test() throws MalformedURLException, AssertionError {
        Model model = ModelComparisonHelper.loadModel((new File("enexa.ttl")).toURI().toURL());
        Assert.assertNotNull(model);
        VocabularyClassTestHelper.runTest(model, ENEXA.class, ENEXA.getURI());
    }
}
