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

    }

//    @Path("/")
//    public static class EntryResource {
//
//        @POST
//        @Path("entry")
//        @Consumes(MediaType.APPLICATION_ATOM_XML)
//        @Produces(MediaType.APPLICATION_ATOM_XML)
//        public AtomAssetMetadata createAssetFromAtom(Entry entry) {
//            try {
//                Class[] classes = new Class[]{AtomAssetMetadata.class, Entry.class};
//                JAXBContext jaxbContext = JAXBContext.newInstance(classes);
//
//                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//                Entry newEntry = (Entry) unmarshaller.unmarshal(new StringBufferInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\"><atom:title>testCreatePackageFromAtom1</atom:title><atom:summary>desc for testCreatePackageFromAtom</atom:summary><metadata><categories><value>AssetPackageResourceTestCategory</value></categories><note><value>meta</value></note></metadata></atom:entry>\n"));
//
//                AtomAssetMetadata assetMetadata = (AtomAssetMetadata) entry.getAnyOther();
//                return assetMetadata;
//            } catch (Exception e) {
//                throw new WebApplicationException(e);
//            }
//        }
//    }
//
//    protected ResteasyDeployment deployment;
//
//    @Before
//    public void before() throws Exception {
//        deployment = EmbeddedContainer.start();
//        deployment.getRegistry().addPerRequestResource(EntryResource.class);
//    }
//
//    @After
//    public void after() throws Exception {
//        EmbeddedContainer.stop();
//        deployment = null;
//    }
//
//
//    @Test
//    public void test() throws Exception
//    {
//       ClientRequest request = new ClientRequest("http://localhost:8081/entry");
//        Thread.sleep(100000);
//       ClientResponse<AtomAssetMetadata> response = request.get(AtomAssetMetadata.class);
//       System.out.println("Received first response: " + response.getEntity());
//
//    }

}
