package com.wangtao.girl.repository;

import com.wangtao.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
public List<Girl> findByName(String name);
}
