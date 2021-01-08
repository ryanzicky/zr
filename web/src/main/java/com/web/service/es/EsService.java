package com.web.service.es;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author zhourui
 * @Date 2020/12/29 15:22
 */
@Slf4j
@Service
public class EsService {


    @Autowired
    private Client client;

    @Value("${douban_mv_index:douban_movie}")
    private String doubanMvIndex;

    public void getMovieList() {
        SearchRequest searchRequest = new SearchRequest(doubanMvIndex);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(1);
        builder.size(10);

        searchRequest.source(builder);

        ActionFuture<SearchResponse> search = client.search(searchRequest);
        log.info("getMovieList.search = {}", JSON.toJSONString(search));
    }
}
