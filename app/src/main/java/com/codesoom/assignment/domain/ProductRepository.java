package com.codesoom.assignment.domain;

import java.util.List;
import java.util.Optional;

/**
 * Product 데이터 저장 장소
 */
public interface ProductRepository {
    /**
     * 저장된 모든 product 반환
     *
     * @return 저장된 모든 product 를 반환
     */
    List<Product> findAll();

    /**
     * 주어진 id 와 일치하는 product 를 반환
     *
     * @param id 식별자
     * @return 주어진 id 와 일치하는 product
     */
    Optional<Product> findById(Long id);

    /**
     * 주어진 product 를 저장하고 반환
     *
     * @param product 저장할 product
     * @return 저장된 product
     */
    Product save(Product product);

    /**
     * 주어진 product 를 삭제
     *
     * @param product 삭제할 product
     */
    void delete(Product product);
}
