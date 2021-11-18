package com.ContactApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ContactApp.dto.AddContactDto;
import com.ContactApp.dto.AddressVoDto;
import com.ContactApp.dto.DateVoDto;
import com.ContactApp.dto.PhoneVoDto;
import com.ContactApp.model.AddContactVo;
import com.ContactApp.model.AddressVo;
import com.ContactApp.model.DateVo;
import com.ContactApp.model.HistoryVo;
import com.ContactApp.model.PhoneVo;

@Repository
public class AddContactDaoImpl implements AddContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveContact(AddContactVo ContactVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(ContactVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveHistory(HistoryVo historyVo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(historyVo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<AddContactDto> viewContact(String searchstr) {
		String hqlquery = "SELECT " + " Contact_table.Contact_id AS Contact_id, " + " Fname," + " Mname," + " Lname,"
				+ " Address_type," + " Address," + " City," + " State," + " Zip," + " Phone_type," + " Area_code,"
				+ " number," + " Date_type," + " Contact_date" + " FROM" + " (" + " (" + " (" + " contact_table"
				+ " INNER JOIN address_table" + " ON contact_table.Contact_id = address_table.Contact_id" + " ) "
				+ " INNER JOIN phone_table" + " ON contact_table.Contact_id = phone_table.Contact_id" + " ) "
				+ " INNER JOIN date_table" + "       ON contact_table.Contact_id = date_table.Contact_id" + "   )"
				+ " GROUP BY contact_table.Contact_id";
		if (searchstr != null && !searchstr.isEmpty()) {

			hqlquery = "SELECT " + " Contact_table.Contact_id AS Contact_id, " + " Fname," + " Mname," + " Lname,"
					+ " Address_type," + " Address," + " City," + " State," + " Zip," + " Phone_type," + " Area_code,"
					+ " number," + " Date_type," + " Contact_date" + " FROM" + " (" + " (" + " (" + " contact_table"
					+ " INNER JOIN address_table" + " ON contact_table.Contact_id = address_table.Contact_id" + " ) "
					+ " INNER JOIN phone_table" + " ON contact_table.Contact_id = phone_table.Contact_id" + " ) "
					+ " INNER JOIN date_table" + "       ON contact_table.Contact_id = date_table.Contact_id" + "   )"
					+ " WHERE Fname LIKE '%" + searchstr + "%'" + "   OR Mname LIKE '%" + searchstr + "%' "
					+ "   OR Lname LIKE '%" + searchstr + "%' " + "   OR Address_type LIKE '%" + searchstr + "%'"
					+ "   OR Address LIKE '%" + searchstr + "%'" + "   OR City LIKE '%" + searchstr + "%'"
					+ "   OR State LIKE '%" + searchstr + "%'" + "   OR Zip LIKE '%" + searchstr + "%' "
					+ "   OR Phone_type LIKE '%" + searchstr + "%'" + "   OR Area_code LIKE '%" + searchstr + "%'"
					+ "   OR Number LIKE '%" + searchstr + "%' " + "   OR Date_type LIKE '%" + searchstr + "%' "
					+ "   OR Contact_Date LIKE '%" + searchstr + "%'" + " GROUP BY contact_table.Contact_id";

		}
		List<AddContactDto> ContactList = new ArrayList<AddContactDto>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createSQLQuery(hqlquery);

			List<Object[]> rows = q.list();

			for (Object[] row : rows) {
				AddContactDto addContactDto = new AddContactDto();
				addContactDto.setId(Integer.parseInt(row[0].toString()));
				addContactDto.setFn(row[1] != null ? row[1].toString() : null);
				addContactDto.setMn(row[2] != null ? row[2].toString(): null);
				addContactDto.setLn(row[3] != null ? row[3].toString(): null);
				
				AddressVoDto addressVoDto = new AddressVoDto();
				addressVoDto.setAddress(row[5] != null ? row[5].toString() : null);
				addressVoDto.setAddressType(row[4] != null ?row[4].toString():null);
				addressVoDto.setCity(row[6] != null ? row[6].toString(): null);
				addressVoDto.setState(row[7] != null ? row[7].toString(): null);
				addressVoDto.setZip(row[8] != null ? row[8].toString(): null);
				
				PhoneVoDto phoneVoDto = new PhoneVoDto();
				phoneVoDto.setPhoneType(row[9] != null ? row[9].toString(): null);
				phoneVoDto.setNumber(row[11] != null ? row[11].toString(): null);
				phoneVoDto.setAreaCode(row[10] != null ? row[10].toString(): null);
				
				DateVoDto dateVoDto = new DateVoDto();
				dateVoDto.setDateType(row[12] != null ? row[12].toString(): null);
				dateVoDto.setContactDate(row[13] != null ? row[13].toString(): null);
				
				addContactDto.setAddressVoDto(addressVoDto);
				addContactDto.setDateVoDto(dateVoDto);
				addContactDto.setPhoneVoDto(phoneVoDto);
				
				ContactList.add(addContactDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ContactList;
	}

	@Override
	public void saveAddress(AddressVo addressVo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(addressVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void savePhone(PhoneVo phoneVo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(phoneVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveDate(DateVo dateVo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(dateVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteContact(AddContactVo ContactVO) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(ContactVO);
			session.merge(ContactVO);
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAddress(AddressVo addressVo) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(addressVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePhone(PhoneVo phoneVo) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(phoneVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDate(DateVo dateVo) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(dateVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List editContact(int id) {

		List<AddContactVo> ContactList = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from AddContactVo where id = " + id);
			ContactList = (List<AddContactVo>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ContactList;

	}

	@Override
	public List editAddress(int id) {
		List<AddressVo> ContactList = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from AddressVo where addContactVo.id = " + id);
			ContactList = (List<AddressVo>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ContactList;

	}

	@Override
	public List editPhone(int id) {
		List<PhoneVo> ContactList = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from PhoneVo where Contact_id = " + id);
			ContactList = (List<PhoneVo>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ContactList;

	}

	@Override
	public List editDate(int id) {
		List<DateVo> ContactList = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from DateVo where Contact_id = " + id);
			ContactList = (List<DateVo>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ContactList;
	}

	@Override
	public List history() {
		List historyList = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from HistoryVo");
			historyList = (List<HistoryVo>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return historyList;
		
	}
}
