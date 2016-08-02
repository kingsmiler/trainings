package com.baeldung.initializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import java.io.Writer;

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
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        return xstream;
    }

    public XStream getXstreamJsonHierarchicalDropRootInstance() {

        XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }
        });

        return xstream;
    }
}