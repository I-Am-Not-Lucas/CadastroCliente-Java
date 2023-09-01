package br.com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.springboot.model.Cliente;


@Repository
@Transactional
public class ClienteDAO implements CRUD <Cliente, Long> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Cliente pesquisaPeloId(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> lista() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("Select c from Cliente c");
		return (List<Cliente>) query.getResultList();
	}

	@Override
	public void insere(Cliente cliente) {
		// TODO Auto-generated method stub
		entityManager.persist(cliente);
	}

	@Override
	public void atualiza(Cliente cliente) {
		// TODO Auto-generated method stub
		entityManager.merge(cliente);
	}

	@Override
	public void remove(Cliente cliente) {
		// TODO Auto-generated method stub
		entityManager.remove(cliente);
	}
	
}
