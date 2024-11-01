package net.abdelghani.jaxrx_tp.repositry;

import net.abdelghani.jaxrx_tp.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
