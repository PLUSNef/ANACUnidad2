package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import utng.model.Prop;

public class PropDOM {
	private String pathFile = "C:\\Users\\Texas\\eclipse-workspace\\ANACU22\\src\\data\\props.xml";

	public void add(Prop data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element props = document.getDocumentElement();
			// crear prop tag
			Element prop = document.createElement("prop");

			// crear id tag
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			prop.appendChild(id);
			// crear seq_id tag
			Element seq = document.createElement("seq");
			seq.appendChild(document.createTextNode(String.valueOf(data.getSeq())));
			prop.appendChild(seq);
			// crear pk tag
			Element pk = document.createElement("pk");
			pk.appendChild(document.createTextNode(data.getPk()));
			prop.appendChild(pk);
			// crear pv tag
			Element pv = document.createElement("pv");
			pv.appendChild(document.createTextNode(data.getPv()));
			prop.appendChild(pv);
			// crear desc tag
			Element desc = document.createElement("desc");
			desc.appendChild(document.createTextNode(data.getDesc()));
			prop.appendChild(desc);
			props.appendChild(prop);
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("prop");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Element prop = (Element) nodeList.item(i);
				if (prop.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					prop.getParentNode().removeChild(prop);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Prop data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("prop");
			for(int i=0; i<nodeList.getLength(); i++) {
				Element prop =(Element)nodeList.item(i);
				if(prop.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					prop.getElementsByTagName("seq").item(0).setTextContent(String.valueOf(data.getSeq()));
					prop.getElementsByTagName("pk").item(0).setTextContent(data.getPk());
					prop.getElementsByTagName("pv").item(0).setTextContent(data.getPv());
					prop.getElementsByTagName("desc").item(0).setTextContent(data.getDesc());
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Prop findById(String id){
		Prop prop = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("prop");
			for(int i=0; i<nodeList.getLength(); i++) {
				Element l=(Element)nodeList.item(i);
				if(l.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					 prop= new Prop();
					prop.setId(id);
					prop.setSeq(Integer.parseInt(l.getElementsByTagName("seq").item(0).getTextContent()));
					prop.setPk(l.getElementsByTagName("pk").item(0).getTextContent());
					prop.setPv(l.getElementsByTagName("pv").item(0).getTextContent());
					prop.setDesc(l.getElementsByTagName("desc").item(0).getTextContent());

				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	public List<Prop> getProps(){
		List<Prop> props= new ArrayList<Prop>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("prop");
		for(int i=0; i<nodeList.getLength(); i++) {
			Element l= (Element)nodeList.item(i);
			Prop prop = new Prop();
			
			prop = new Prop();
			prop.setId(l.getElementsByTagName("id").item(0).getTextContent());	
			prop.setSeq(Integer.parseInt(l.getElementsByTagName("seq").item(0).getTextContent()));
			prop.setPk(l.getElementsByTagName("pk").item(0).getTextContent());
			prop.setPv(l.getElementsByTagName("pv").item(0).getTextContent());
			prop.setDesc(l.getElementsByTagName("desc").item(0).getTextContent());
			
			props.add(prop);
		}
		
		return props;
	}
	
}
