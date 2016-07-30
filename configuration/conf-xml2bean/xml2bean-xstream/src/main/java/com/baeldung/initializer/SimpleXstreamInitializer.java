package com.baeldung.initializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class SimpleXstreamInitializer {

    public XStream getXstreamInstance() {
        XStream xstreamInstance = new XStream();
        return xstreamInstance;
    }

    public XStream getXstreamJettisonMappedInstance() {
        XStream xstreamInstance = new XStream(new JettisonMappedXmlDriver());
        return xstreamInstance;
    }

    public XStream getXstreamJsonHierarchicalInstance() {
        XStream xstreamInstance = new XStream(new JsonHierarchicalStreamDriver());
        return xstreamInstance;
    }
}