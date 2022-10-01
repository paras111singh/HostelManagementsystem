package serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import dao.adminDao;
import daoImpl.adminDaoImpl;
import exception.GlobalException;
import model.room;
import model.user;
import service.admindashboard;

public class admindashboardImpl implements admindashboard {
	
	static Logger log=Logger.getLogger(admindashboardImpl.class);
	static Scanner bs=new Scanner(System.in);
	static admindashboard adl=new admindashboardImpl();
	static adminDao dao=new adminDaoImpl();
	@Override
	public void dashboard() throws GlobalException {
		log.info("\t\t\t-------------------welcome to Admin dashboard----------------");
		
		int op=0;
		while(op<10)
		{
			
		log.info("\n\tPress 1 for View Rooms\t\t\tPress 2 for View Users\n\tPress 3 for Create Rooms\t\tPress 4 for Allot room to user\n\tPress 5 for view user in a room\t\tPress 6 for view user profile\n\tPress 7 for Add Due Amount\t\tPress 8 for Pay Due Amount\n\tPress 9 for delete user");
		
		op=bs.nextInt();
		switch(op) {
		
		case 1->adl.viewRooms();
		case 2->adl.viewUsers();
		case 3->adl.createRoom();
		case 4->adl.allotRoom();
		case 5->adl.userInARoom();
		case 6->adl.viewuserprofile();
		case 7->adl.addDueAmount();
		case 8->adl.paidDueAmount();
		case 9->adl.deleteUser();
		default->System.exit(0);
		}
	}
	}

	@Override
	public void viewRooms() {
		List<room> roomList=dao.viewRooms();
		log.info("\nroom num\t\troomName\t\troomType");
		for(room r:roomList)
			log.info("\t"+r.getRoomId()+"\t\t"+r.getRoomName()+"\t\t"+r.getRoomType());
	}

	@Override
	public void viewUsers() {
		List<user> userList=dao.viewUsers();
		log.info("\nUser Id\t\tUserName\t\tuser Phone\t\tuserRoom");
		for(user u1:userList)
			log.info("\t"+u1.getUserId()+"\t\t"+u1.getUserName()+"\t\t"+u1.getUserPhone()+"\t\t"+u1.getUserRoom().getRoomId());
		
	}

	@Override
	public void createRoom()  {
		log.info("Enter Room Id");
		int id=bs.nextInt();
		log.info("Enter Room Name");
		String rname=bs.next();
		log.info("Enter Room Type");
		String rtype=bs.next();
		room r1=new room();
		r1.setRoomId(id);
		r1.setRoomName(rname);
		r1.setRoomType(rtype);
		try {
			int st=dao.createRoom(r1);
			if(st==1) {
				log.info("room added successfully");
			}
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
		
		
	}

	@Override
	public void allotRoom() throws GlobalException {
		
		log.info("Enter user Id");
		int uid=bs.nextInt();
		log.info("Enter room Id");
		int rId=bs.nextInt();
		int st=dao.allotRoom(uid, rId);
		if(st==1) {
			log.info("Room alloted successfully");
		}
		else {
			throw new GlobalException("Something went wrong");
		}
		
	}

	@Override
	public void deleteUser() throws GlobalException {
		log.info("Enter user Id to delete");
		int uid=bs.nextInt();
		int st=dao.deleteUser(uid);
		if(st==1) {
			log.info("deleted!...");
		}
		else {
			throw new GlobalException("Something went wrong");
		}
	}

	@Override
	public void userInARoom() {
		log.info("Enter Room Id");
		int rid=bs.nextInt();
	List<user> userList=	dao.userInARoom(rid);
	log.info("\nUser Id\t\tUserName\t\tuser Phone");
	for(user u1:userList)
		log.info("\t"+u1.getUserId()+"\t\t"+u1.getUserName()+"\t\t"+u1.getUserPhone());
	}

	@Override
	public void addDueAmount() throws GlobalException {
		log.info("Enter Amount to add");
		int amount=bs.nextInt();
		log.info("Enter user Id");
		int uid=bs.nextInt();
		int st=dao.addDueAmount(uid, amount);
		if(st==1) {
			log.info("amount added");
		}
		else {
			throw new GlobalException("Something went wrong");
		}
	}

	@Override
	public void paidDueAmount() throws GlobalException {
		log.info("Enter Amount to pay");
		int amount=bs.nextInt();
		log.info("Enter user Id");
		int uid=bs.nextInt();
		int st=dao.paidDueAmount(uid, amount);
		if(st==1) {
			log.info("amount added");
		}
		else {
			throw new GlobalException("Something went wrong");
		}	
	}

	@Override
	public void viewuserprofile() throws GlobalException {
		log.info("Enter user id");
		int uid=bs.nextInt();
		user u1=dao.viewuserprofile(uid);
		log.info(u1);
	}

}