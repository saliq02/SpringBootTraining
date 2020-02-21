package com.cts.actor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cts.actor.model.Actor;

@Repository
public class ActorDAOImpl {

	@Autowired
	private JdbcTemplate jt;

	public List<Actor> findAll() {
		
		List<Actor> actors = jt.queryForObject("select * from sakila.actor", new RowMapperDemo());
		
		return actors;
	}
	
	public List<Actor> findAll_v1(){
		List<Actor> actors = jt.query("select * from sakila.actor", new ResultSetExtractorDemo());
		return actors;
	}
	
	public int saveActor(Actor actor)
	{
		int noOfRows = jt.update("insert into sakila.actor(actor_id,first_name,last_name) values(?,?,?)", actor.getActorId(),actor.getActorName(),"test");
		System.out.println("Row inserted successfully");
		return noOfRows;
	}
	
	public void updateActor(String fname, Actor actor)
	{
		jt.update("update sakila.actor set first_name='"+fname+"' where actor_id=?",actor.getActorId());
		System.out.println("Row updated successfully");
	}
	
	public void deleteActor(Actor actor)
	{
		jt.update("delete from sakila.actor where actor_id=?",actor.getActorId());
		System.out.println("Row deleted successfully");
	}
}


class ResultSetExtractorDemo implements ResultSetExtractor<List<Actor>>
{
	
	public List<Actor> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Actor> actors = new ArrayList<Actor>();

		System.out.println("Actor ID | Name");
		while (rs.next()) {
			Actor actor = new Actor();
			actor.setActorId(rs.getInt("actor_id"));
			actor.setActorName(rs.getString("first_name"));

			System.out.println(actor.getActorId() + "|" + actor.getActorName());
			
			actors.add(actor);
		}
		return actors;
	

}
}


class RowMapperDemo implements RowMapper<List<Actor>> {
	List<Actor> actors = new ArrayList<Actor>();

	public List<Actor> mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("Actor ID | Name");
		while (rs.next()) {
			Actor actor = new Actor();
			actor.setActorId(rs.getInt("actor_id"));
			actor.setActorName(rs.getString("first_name"));

			System.out.println(actor.getActorId() + "|" + actor.getActorName());
			
			actors.add(actor);
		}
		return actors;
	}
}
