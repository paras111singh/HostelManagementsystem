/**
 * HOSTEL MANAGEMENT STSTEM
 * @author Paras Singh
 * Illustrating UNIT TESTING OF HOSTEL MANAGEMENT SYSTEM
 * UNIT TESTING OF PRINT DATA OF ONE OR ALL USER USING LOGGER, DELETE USER AND ROOM USING DATA ACCESS OBJECT AND HQL 
 * TESTING OF METHOD OF HOTELMS, USER AND ADMIN DASHBOARD METHOD USING JUNIT TEST CASES
 * USED POSITIVE AND NEGATIVE TEST CASES TO PERFORM TESTING OF FOLLOWING METHOD 
 */
package com.hostelMS;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dao.adminDao;
import dao.hostelMSDao;
import dao.userDao;
import daoImpl.adminDaoImpl;
import daoImpl.hostelMSDaoImpl;
import daoImpl.userDaoImpl;
import exception.GlobalException;
import model.room;
import model.user;

//test class
public class AppTest {

	// perform testing on registration
	@Test
	@Disabled
	@DisplayName("Registeration Test")
	public void registrationTest() {

		hostelMSDao dao = new hostelMSDaoImpl();
		user u1 = new user();

		u1.setUserName("Paras");
		u1.setUserPassword("12345");
		u1.setUserPhone("7050398448");
		u1.setUserRole("student");
		u1.setUserAddress("BAnglore");

		user u2 = new user();
		u2.setUserName("Singh");
		u2.setUserPassword("67890");
		u2.setUserPhone("9608939423");
		u2.setUserRole("student");
		u2.setUserAddress("sector168");

		assertAll(
				// positive testing for registration method
				() -> assertEquals(1, dao.registration(u1)),
				// negative testing for registration method using exception
				() -> assertThrows(GlobalException.class, () -> dao.registration(u2)));

	}

	// testing of changePassword method
	@Test
	@Disabled
	public void testChangePassword() {

		userDao dao = new userDaoImpl();
		assertAll(
				// positive testing for changePassword method
				() -> assertEquals(1, dao.changePassword(4, "par123", "123par")),
				// negative testing for changePassword method using exception
				() -> assertThrows(Exception.class, () -> dao.changePassword(4, "sin123", "123sin"))

		);
	}

	// 3
	// testing over changePhonenumber method
	@Test
	@Disabled
	public void testchangePhone() {

		userDao dao = new userDaoImpl();
		assertAll(
				// positive test case for password changing
				() -> assertEquals(1, dao.changePhone(3, "7050835360")),
				// negative test case for password changing
				() -> assertEquals(0, dao.changePhone(50, "9608991391"))

		);
	}

	// 4 performing testing over CreateRoom method
	@Test
	@Disabled
	public void testCreateRoom() {

		// creating dao object to create room entity
		adminDao dao = new adminDaoImpl();
		room r1 = new room();
		r1.setRoomId(2);
		r1.setRoomName("Asus");
		r1.setRoomType("vivobook");

		room r2 = new room();
		r2.setRoomId(1);
		r2.setRoomName("msi");
		r2.setRoomType("bravo");
		assertAll(
				// test to create room
				() -> assertEquals(1, dao.createRoom(r1)),
				// testing to check if exception works in createRoom method
				() -> assertThrows(GlobalException.class, () -> dao.createRoom(r2))

		);
	}}
