//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.09 at 11:50:40 AM CEST 
//


package com.mxgraph.examples.config;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mxgraph.examples.config package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mxgraph.examples.config
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SCXMLConstraints }
     * 
     */
    public SCXMLConstraints createSCXMLConstraints() {
        return new SCXMLConstraints();
    }

    /**
     * Create an instance of {@link SCXMLConstraints.RestrictedAction }
     * 
     */
    public SCXMLConstraints.RestrictedAction createSCXMLConstraintsRestrictedAction() {
        return new SCXMLConstraints.RestrictedAction();
    }

    /**
     * Create an instance of {@link SCXMLConstraints.RestrictedInformation }
     * 
     */
    public SCXMLConstraints.RestrictedInformation createSCXMLConstraintsRestrictedInformation() {
        return new SCXMLConstraints.RestrictedInformation();
    }

    /**
     * Create an instance of {@link SCXMLConstraints.RestrictedState }
     * 
     */
    public SCXMLConstraints.RestrictedState createSCXMLConstraintsRestrictedState() {
        return new SCXMLConstraints.RestrictedState();
    }

    /**
     * Create an instance of {@link SCXMLConstraints.RestrictedAction.PossibleAction }
     * 
     */
    public SCXMLConstraints.RestrictedAction.PossibleAction createSCXMLConstraintsRestrictedActionPossibleAction() {
        return new SCXMLConstraints.RestrictedAction.PossibleAction();
    }

    /**
     * Create an instance of {@link SCXMLConstraints.RestrictedInformation.PossibleInformation }
     * 
     */
    public SCXMLConstraints.RestrictedInformation.PossibleInformation createSCXMLConstraintsRestrictedInformationPossibleInformation() {
        return new SCXMLConstraints.RestrictedInformation.PossibleInformation();
    }

    /**
     * Create an instance of {@link SCXMLConstraints.RestrictedState.PossibleEvent }
     * 
     */
    public SCXMLConstraints.RestrictedState.PossibleEvent createSCXMLConstraintsRestrictedStatePossibleEvent() {
        return new SCXMLConstraints.RestrictedState.PossibleEvent();
    }

}
