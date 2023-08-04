package org.dice_research.enexa.vocab;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFLanguages;

/**
 * This class represents the basis of an RDF vocabulary that uses the
 * <a href="https://www.iana.org/assignments/media-types/">IANA media type
 * page</a> and the media types listed on it as IRIs for those media types. This
 * class does not offer a list of {@link Resource} instances that are already
 * created since that would use a large amount of memory. Instead, it offers
 * method to easily create these instances.
 * 
 * This vocabulary uses the namespace {@value #IRI}.
 * 
 * @author Michael R&ouml;der (michael.roeder@uni-paderborn.de)
 *
 */
public class IANAMediaType {

    protected static final String IRI = "https://www.iana.org/assignments/media-types/";

    /**
     * returns the IRI for this schema
     *
     * @return the IRI for this schema
     */
    public static String getIRI() {
        return IRI;
    }

    /**
     * This method returns the content type String for the given IANA IRI.
     * 
     * @param iri the IRI for which the content type String should be returned.
     * @return the content type String for the given IRI or {@code null} if the
     *         given IRI is {@code null} or if it does not belong to the IANA
     *         vocabulary namespace.
     */
    // @CheckForNull
    public static String iri2ContentType(String iri) {
        if (iri != null && iri.startsWith(IRI)) {
            return iri.substring(IRI.length());
        } else {
            return null;
        }
    }

    /**
     * This method returns the RDF language for the given IANA IRI (if this IRI
     * represents such a language).
     * 
     * @param iri the IRI for which the RDF language should be returned.
     * @return the RDF language for the given IANA IRI or {@code null} if the given
     *         IRI is {@code null} or if it does not belong to the IANA vocabulary
     *         namespace or if it does not represent a known RDF language.
     */
    // @CheckForNull
    public static Lang iri2Lang(String iri) {
        return RDFLanguages.contentTypeToLang(iri2ContentType(iri));
    }

    /**
     * This method provides the IANA IRI for the given RDF language.
     * 
     * @param lang the language for which the IRI should be created.
     * @return the IANA IRI for the given RDF language or {@code null} if the given
     *         language is {@code null}.
     */
    // @CheckForNull
    public static String lang2Iri(Lang lang) {
        if (lang != null) {
            return IRI + lang.getContentType().getContentTypeStr();
        } else {
            return null;
        }
    }

    /**
     * This method provides a {@link Resource} representing the given RDF language
     * in the IANA vocabulary.
     * 
     * @param lang the language for which a Resource should be created.
     * @return the given RDF language in the IANA vocabulary or {@code null} if the
     *         given language is {@code null}.
     */
    // @CheckForNull
    public static Resource lang2Resource(Lang lang) {
        if (lang != null) {
            return ResourceFactory.createResource(lang2Iri(lang));
        } else {
            return null;
        }
    }

    /**
     * This method returns the content type String for the given IANA Resource.
     * 
     * @param ianaResource the Resource for which the content type String should be
     *                     returned.
     * @return the content type String for the given Resource or {@code null} if the
     *         given Resource is {@code null} or if it does not belong to the IANA
     *         vocabulary namespace.
     */
    // @CheckForNull
    public static String resource2ContentType(Resource ianaResource) {
        if (ianaResource != null && ianaResource.isURIResource()) {
            return iri2ContentType(ianaResource.getURI());
        } else {
            return null;
        }
    }

    /**
     * This method returns the RDF language for the given IANA Resource (if this
     * Resource represents such a language).
     * 
     * @param ianaResource the Resource for which the RDF language should be
     *                     returned.
     * @return the RDF language for the given IANA Resource or {@code null} if the
     *         given IRI is {@code null} or if it does not belong to the IANA
     *         vocabulary namespace or if it does not represent a known RDF
     *         language.
     */
    // @CheckForNull
    public static Lang resource2Lang(Resource ianaResource) {
        if (ianaResource != null && ianaResource.isURIResource()) {
            return iri2Lang(ianaResource.getURI());
        } else {
            return null;
        }
    }

}
