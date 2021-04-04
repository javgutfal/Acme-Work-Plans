package acme.base.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import acme.base.service.BaseService;

@Transactional
public class AbstractService<T> implements BaseService<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Repositorio genérico */
	@Autowired
	protected JpaRepository<T, Serializable> genericRepository;

	@Override
	public Optional<T> findById(final Integer id) {
		return this.genericRepository.findById(id);
	}

	@Override
	public List<T> findAll() {
		return this.genericRepository.findAll();
	}

	@Override
	public T save(final T entity) {
		return this.genericRepository.save(entity);
	}

	@Override
	public List<T> saveAll(final Iterable<T> entities) {
		return this.genericRepository.saveAll(entities);
	}

	@Override
	public void delete(final T entity) {
		this.genericRepository.delete(entity);		
	}

	@Override
	public void deleteById(final Integer id) {
		this.genericRepository.deleteById(id);
	}

	@Override
	public void deleteByIdSiExiste(final Integer id) {
		if(this.genericRepository.existsById(id)) {
			this.genericRepository.deleteById(id);
		}
	}

	@Override
	public void deleteAll(final List<T> entities) {
		this.genericRepository.deleteAll(entities);
	}

}
