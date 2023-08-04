package org.dice_research.enexa.vocab;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.WebContent;
import org.junit.Assert;
import org.junit.Test;

public class IANAMediaTypeTest {

    @Test
    public void testTurtle() {
        String iri = "https://www.iana.org/assignments/media-types/text/turtle";
        Resource expectedResource = ResourceFactory.createResource(iri);
        String expectedContentType = WebContent.contentTypeTurtle;

        Assert.assertEquals(expectedResource, IANAMediaType.lang2Resource(Lang.TURTLE));

        Assert.assertEquals(expectedContentType, IANAMediaType.iri2ContentType(iri));

        Assert.assertEquals(Lang.TURTLE, IANAMediaType.iri2Lang(iri));

        Assert.assertEquals(expectedContentType, IANAMediaType.resource2ContentType(expectedResource));

        Assert.assertEquals(Lang.TURTLE, IANAMediaType.resource2Lang(expectedResource));
    }

    @Test
    public void testJSONLD() {
        String iri = "https://www.iana.org/assignments/media-types/application/ld+json";
        Resource expectedResource = ResourceFactory.createResource(iri);
        String expectedContentType = WebContent.contentTypeJSONLD;

        Assert.assertEquals(expectedResource, IANAMediaType.lang2Resource(Lang.JSONLD));

        Assert.assertEquals(expectedContentType, IANAMediaType.iri2ContentType(iri));

        Assert.assertEquals(Lang.JSONLD, IANAMediaType.iri2Lang(iri));

        Assert.assertEquals(expectedContentType, IANAMediaType.resource2ContentType(expectedResource));

        Assert.assertEquals(Lang.JSONLD, IANAMediaType.resource2Lang(expectedResource));
    }
    
    @Test
    public void testNull() {
        Assert.assertNull(IANAMediaType.iri2ContentType(null));
        Assert.assertNull(IANAMediaType.iri2ContentType("http://example.org/something"));
        
        Assert.assertNull(IANAMediaType.iri2Lang(null));
        Assert.assertNull(IANAMediaType.iri2Lang("http://example.org/something"));
        
        Assert.assertNull(IANAMediaType.lang2Iri(null));
        
        Assert.assertNull(IANAMediaType.lang2Resource(null));

        Resource randomResource = ResourceFactory.createResource("http://example.org/something");
        Resource bNodeResource = ResourceFactory.createResource();
        
        Assert.assertNull(IANAMediaType.resource2ContentType(null));
        Assert.assertNull(IANAMediaType.resource2ContentType(randomResource));
        Assert.assertNull(IANAMediaType.resource2ContentType(bNodeResource));
        
        Assert.assertNull(IANAMediaType.resource2Lang(null));
        Assert.assertNull(IANAMediaType.resource2Lang(randomResource));
        Assert.assertNull(IANAMediaType.resource2Lang(bNodeResource));
    }
}
