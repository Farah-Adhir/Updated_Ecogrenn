package com.java.ecogreen.category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "category_master")
	public class Category {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cat_id;
		private String cat_name;
		private String cat_type;
		public int getCat_id() {
			return cat_id;
		}
		public void setCat_id(int cat_id) {
			this.cat_id = cat_id;
		}
		public String getCat_name() {
			return cat_name;
		}
		public void setCat_name(String cat_name) {
			this.cat_name = cat_name;
		}
		public String getCat_type() {
			return cat_type;
		}
		public void setCat_type(String cat_type) {
			this.cat_type = cat_type;
		}
		public Category(int cat_id, String cat_name, String cat_type) {
			super();
			this.cat_id = cat_id;
			this.cat_name = cat_name;
			this.cat_type = cat_type;
		}
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name + ", cat_type=" + cat_type + "]";
		}
		
}
