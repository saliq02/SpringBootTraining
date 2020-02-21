package com.cts.actor;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cts.actor.config.AppConfig;
import com.cts.actor.dao.ActorDAOImpl;
import com.cts.actor.model.Actor;

public class ActorController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ActorDAOImpl dao = ac.getBean(ActorDAOImpl.class);
		//List<Actor> actors = dao.findAll_v1();
		
		Actor actor = new Actor();
		actor.setActorId(201);
		actor.setActorName("Test");
		
		//Calling insert operation
		//dao.saveActor(actor);
		
		//Calling Update Operation
		//dao.updateActor("FName",actor);
		
		//Calling Delete operation
		dao.deleteActor(actor);
		
		ac.close();
	}

}
