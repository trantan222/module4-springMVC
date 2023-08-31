package com.example.foot_ball.repository;

import com.example.foot_ball.model.Khach_hang;
import com.example.foot_ball.model.Khu_vuc;
import com.example.foot_ball.model.Loai_san;
import com.example.foot_ball.model.San_bong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepoSan_Bong extends JpaRepository<San_bong,Long> {
    Page<San_bong> findAllByNameContaining(Pageable pageable,String name);
    Page<San_bong> findAllByKhuVuc(Pageable pageable, Khu_vuc khu_vuc);
    Page<San_bong> findAllByLoaiSan(Pageable pageable, Loai_san loai_san);
    Page<San_bong> findAllByNameContainingAndKhuVucAndLoaiSan(Pageable pageable,String name,Khu_vuc khu_vuc,Loai_san loai_san);


}
