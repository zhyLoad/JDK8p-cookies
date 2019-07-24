/**
 * 
 */
package com.test.jndi;

import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapName;

import com.test.jndi.entity.InetOrgPerson;
import com.test.jndi.entity.LdapConnection;

/**
 * @author 10007610
 *
 */
public class LdapImpl implements Ldap {
	
	private DirContext ds;
	

	@Override
	public void search(String searchFilter,String searchBase,String[] returnedAtts) throws NamingException {
		System.out.println("Searching...");
		SearchControls searchCtls = new SearchControls();
		// Specify the search scope
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		searchCtls.setReturningAttributes(returnedAtts);
		// Search for objects using the filter
		NamingEnumeration<SearchResult> entries = ds.search(searchBase,
				searchFilter, searchCtls);

		// Loop through the search results
		while (entries.hasMoreElements()) {
			SearchResult entry = entries.next();
			System.out.println(">>>" + entry.getName());
			// Print out the groups
			Attributes attrs = entry.getAttributes();
			if (attrs != null) {
				for (NamingEnumeration<? extends Attribute> names = attrs
						.getAll(); names.hasMore();) {
					Attribute attr = names.next();
					System.out.println("AttributeID: " + attr.getID());
					for (NamingEnumeration<?> e = attr.getAll(); e.hasMore();) {
						System.out.println("Attributes:" + e.next());
					}
				}
			}
		}
		System.out.println("Search complete.");
	}
	
/** 
* 通过属性搜索LDAP范例  
* @return 
*/  
public void searchByAttribute(String baseDN,Map<String,String> queryAtts) throws NamingException {  
    SearchControls cons = new SearchControls();  
    cons.setSearchScope(SearchControls.SUBTREE_SCOPE);  
    System.out.println("Searching...");
    Name baseName = new LdapName(baseDN);  
    Attributes matchAttrs = new BasicAttributes(true);
    for(Map.Entry<String, String> entity :queryAtts.entrySet()){
    	 matchAttrs.put(new BasicAttribute(entity.getKey(), entity.getValue()));//指定必须含有sn属性，其值必须是GGG
    }
    NamingEnumeration<SearchResult> ne = ds.search(baseName, matchAttrs);  
    SearchResult entry = null;  
    for(;ne.hasMore();){  
       entry = ne.next();  
		System.out.println(">>>" + entry.getName());
		// Print out the groups
		Attributes attrs = entry.getAttributes();
		if (attrs != null) {
			for (NamingEnumeration<? extends Attribute> names = attrs
					.getAll(); names.hasMore();) {
				Attribute attr = names.next();
				System.out.println("AttributeID: " + attr.getID());
				for (NamingEnumeration<?> e = attr.getAll(); e.hasMore();) {
					System.out.println("Attributes:" + e.next());
				}
			}
		}
    }
	System.out.println("Search complete.");
}

	@Override
	public void update(String dn,Attribute attr) throws NamingException {
		System.out.println("Updating...");
		 ModificationItem[] mods = new ModificationItem[1];
         // Support add, replace and remove an attribute.
         mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);
         ds.modifyAttributes(dn, mods);
		System.out.println("Updated.");
	}

	@Override
	public void add(InetOrgPerson inetOrgPerson) throws NamingException {
		System.out.println("Adding...");
		Attributes attrs = new BasicAttributes();
		attrs.put("uid", inetOrgPerson.getUid());
		attrs.put("sn", inetOrgPerson.getSn());
		attrs.put("cn", inetOrgPerson.getCn());
		attrs.put("userPassword",inetOrgPerson.getPassword().getBytes());
		// the following attribute has two values
		Attribute objclass = new BasicAttribute("objectClass");
		objclass.add("inetOrgPerson");
		attrs.put(objclass);

		this.ds.createSubcontext(inetOrgPerson.getDn(), attrs);
		System.out.println("Add complete.");
	}


	public void delete(String dn) throws NamingException {
		System.out.println("Deleting dn=["+dn+"]...");
		this.ds.destroySubcontext(dn);
		System.out.println("dn=["+dn+"] Deleted.");
	}

	@Override
	public synchronized void connect(LdapConnection ldapConnection) throws NamingException {
		System.out.println("connecting ldap server begin ...url=["+ldapConnection.getLdapServerUrl()+"]");
		if (ds == null) {
			Hashtable<String, Object> env = new Hashtable<String, Object>(11);
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, ldapConnection.getLdapServerUrl());
			env.put(Context.SECURITY_AUTHENTICATION, ldapConnection.getLdapServerAuthenticationType());
			env.put(Context.SECURITY_PRINCIPAL, ldapConnection.getLdapServerAccount());
			env.put(Context.SECURITY_CREDENTIALS, ldapConnection.getLdapServerPassword());
			ds = new InitialDirContext(env);
		}
		System.out.println("connected.url=["+ldapConnection.getLdapServerUrl()+"]");
	}

	@Override
	public void close() throws NamingException {
		System.out.println("closing...");
		ds.close();
		System.out.println("closed.");
	}


}
