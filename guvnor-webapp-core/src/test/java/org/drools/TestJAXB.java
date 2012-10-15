package org.drools;

import org.drools.guvnor.server.jaxrs.jaxb.AtomAssetMetadata;
import org.drools.guvnor.server.jaxrs.providers.atom.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringBufferInputStream;

/**
 * 09 25 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class TestJAXB {

    public static void main(String[] args) throws Exception {
        Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
        JAXBContext jaxbContext = JAXBContext.newInstance(classes);

        Entry entry = new Entry();
        entry.setTitle("testCreatePackageFromAtom1");
        entry.setSummary("desc for testCreatePackageFromAtom");
        AtomAssetMetadata meta = new AtomAssetMetadata();
        meta.setNote("meta");
        meta.setCategories(new String[]{"AssetPackageResourceTestCategory"});

        entry.setAnyOtherJAXBObject(meta);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringBuffer buffer = new StringBuffer();
        marshaller.marshal(entry, System.out);


        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Entry newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\"><atom:title>testCreatePackageFromAtom1</atom:title><atom:summary>desc for testCreatePackageFromAtom</atom:summary><metadata><categories><value>AssetPackageResourceTestCategory</value></categories><note><value>meta</value></note></metadata></atom:entry>\n"));

        System.out.println(newEntry.getAnyOther());

        newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<entry xmlns=\"http://www.w3.org/2005/Atom\"><title type=\"text\">testCreatePackageFromAtom1</title><summary type=\"text\">desc for testCreatePackageFromAtom</summary><metadata xmlns=\"\"><categories><value>AssetPackageResourceTestCategory</value></categories></metadata></entry>\n"));

        System.out.println(newEntry.getAnyOther());
    }

}
