/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.PrimeHighCharts.MB;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TabViewController implements Serializable{
	private List<TabItem> tabList;
	private int activeIndex = 0;

	public TabViewController(){
		tabList = new ArrayList<TabItem>();

		tabList.add(new TabItem("tab1", "teste.xhtml", 0));
		tabList.add(new TabItem("tab2", "teste2.xhtml", 1));
	}
	
	public List<TabItem> getTabList() {
		return tabList;
	}

	public void setTabList(List<TabItem> tabList) {
		this.tabList = tabList;
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}

	public class TabItem implements Serializable{
		private String title;
		private String id;
		private String name;
		private String url;
		private int tabIndex;
		private String label;

		public TabItem(String name, String url, int tabIndex)
		{
			this.setName(name);
			this.setUrl(url);
			this.setTabIndex(tabIndex);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public int getTabIndex() {
			return tabIndex;
		}

		public void setTabIndex(int tabIndex) {
			this.tabIndex = tabIndex;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		//getters and setters...
		
	}
}
