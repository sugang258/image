package com.example.demo.repository;

import com.example.demo.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager em;

    //회원등록
    public void save(Member member) {
        em.persist(member);
    }

    //회원 1명 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //모든 회원 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //이름으로 회원 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }




    public void saveMember(Member member) {
        em.persist(member);
    }

    public Member findMember(Long userId) {
        return em.find(Member.class, userId);
    }

}
