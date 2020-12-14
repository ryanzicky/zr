### 创建索引：

```
PUT /product?pretty
```

### 查询分片信息

```
GET _cat/indices?v
```

### 删除索引

```
DELETE /product?pretty
```

### 查询数据

```
GET /product/_doc/_search
GET /product/_doc/1
```

### 修改数据(全量替换)

```json
PUT /product/_doc/1
{
  "name":"xiaomi phone",
  "desc":"shouji zhong de zhandouji",
  "price":13999,
  "tags":["xingjiabi","fashao","buka"]
}
```

### 修改执行字段

```json
POST /product/_doc/1/_update
{
  "doc":{
    "price":3999
  }
}
```



### 插入测试数据：

```json
PUT /product/_doc/1
{
  "name":"xiaomi phone",
  "desc":"shouji zhong de zhandouji",
  "price":3999,
  "tags":["xingjiabi","fashao","buka"]
}

PUT /product/_doc/2
{
  "name":"xiaomi nfc phone",
  "desc":"zhichi quangongneng nfc, shouji zhongde jianjiji",
  "price":4999,
  "tags":["xingjiabi","fashao","gongjiaoka"]
}

PUT /product/_doc/3
{
  "name":"nfc phone",
  "desc":"shouji zhong de hongzhaji",
  "price":2999,
  "tags":["xingjiabi","fashao","menjinka"]
}

PUT /product/_doc/4
{
  "name":"xiaomi erji",
  "desc":"erji zhong de huangmenji",
  "price":999,
  "tags":["low","bufangshui","yinzhicha"]
}

PUT /product/_doc/5
{
  "name":"hongmi erji",
  "desc":"erji zhong de kendeji",
  "price":399,
  "tags":["lowbee","xuhangduan","zhiliangx"]
}
```

### 查询sql

```jsx
1. GET /product/_search
2. GET /_search?timeout=1s
3. GET /product/_doc/_search?q=name:xiaomi
4. GET /product/_search?from=0&size=2&sort=price:asc

5. GET /product/_search
{
  "query":{
    "match_all":{}
  }
}

6. GET /product/_search
{
  "query":{
    "match":{
      "name":"nfc"
    }
  }
}

7. GET /product/_search
{
  "query":{
    "match":{
      "name":"nfc"
    }
  },
  "sort": [
    {
      "price": "desc"
    }
  ]
}

8. GET /product/_search
{
  "query":{
    "multi_match":{
      "query":"nfc",
      "fields": ["name","desc"]
    }
  },
  "sort": [
    {
      "price": "desc"
    }
  ]
}

9. GET /product/_search
{
  "query": {
    "match_all": {}
  },
  "_source": ["name","price"]
}
```

```jsx
PUT /product?pretty
GET _cat/indices?v
DELETE /product?pretty

GET /product/_doc/_search
GET /product/_doc/1

PUT /product/_doc/1
{
  "name":"xiaomi phone",
  "desc":"shouji zhong de zhandouji",
  "price":13999,
  "tags":["xingjiabi","fashao","buka"]
}

POST /product/_doc/1/_update
{
  "doc":{
    "price":13999
  }
}

DELETE /product/_doc/1

GET /product/_search
GET /_search?timeout=1s
GET /product/_doc/_search?q=name:xiaomi
GET /product/_search?from=0&size=2&sort=price:asc

GET /product/_search
{
  "query": {
    "match_all": {}
  },
  "_source": ["name","price"]
}

GET /product/_search
{
  "query": {
    "match_all": {}
  },
  "from": 0,
  "size": 2,
  "sort": [
    {
      "price": "asc"
    }
  ]
}

# 全文检索

GET /product/_search
{
  "query": {
    "term": {
      "name": "nfc"
    }
  }
}
# query-term 不会被分词
GET /product/_search
{
  "query": {
    "term": {
      "name": "nfc phone"
    }
  }
}

GET /product/_search
{
    "query": {
        "bool": {
            "must": [
                {
                    "term": {
                        "name": "nfc"
                    }
                },
                {
                    "term": {
                        "name": "phone"
                    }
                }
            ]
        }
    }
}
# select * from product where name in ()
GET /product/_search
{
  "query": {
    "terms": {
      "name": ["nfc","phone"]
    }
  }
}

GET /product/_search
{
  "query": {
    "match": {
      "name": "nfc phone"
    }
  }
}

GET /product/_search
{
  "query": {
    "match": {
      "name": "xiaomi nfc zhineng phone"
    }
  }
}

# 分词器
GET /_analyze
{
  "analyzer": "standard",
  "text": "xiaomi nfc zhineng phone"
}

GET /product/_search
{
  "query": {
    "match_phrase": {
      "name": "nfc phone"
    }
  }
}

# filter不计算相关度，性能比query高
GET /product/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "name": "xiaomi"
          }
        },
        {
          "match": {
            "desc": "shouji"
          }
        }
      ],
      "filter": [
        {
          "match_phrase":{
            "name":"xiaomi phone"
          }
        },
        {
          "range": {
            "price": {
              "gt": 1999
            }
          }
        }
      ]
    }
  }
}

GET /product/_search
{
  "query": {
    "bool": {
      "must_not": [
        {
          "match": {
            "name": "erji"
          }
        }
      ],
      "must": [
        {
          "match": {
            "name": "xiaomi"
          }
        }
      ],
      "should": [
        {
          "match": {
            "desc": "nfc"
          }
        }
      ],
      "filter": [
        {
          "range": {
            "price": {
              "gt": 4999
            }
          }
        }
      ]
    }
  }
}

GET /product/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "name": "nfc"
          }
        }
      ],
      "should": [
        {
          "range": {
            "price": {
              "gt": 1999
            }
          }
        },
        {
          "range": {
            "price": {
              "gt": 3999
            }
          }
        }
      ],
      "minimum_should_match": 2
    }
  }
}

# filter
GET /product/_search
{
  "query": {
    "constant_score": {
      "filter": {
        "range": {
          "price": {
            "gte": 399,
            "lte": 3999
          }
        }
      }
    }
  }
}

GET /product/_search
{
  "query": {
    "constant_score": {
      "filter": {
        "bool": {
          "should":[
            {
              "term":{
                "name":"xiaomi"
              }
            },
            {
              "term":{
                "name":"nfc"
              }
            }
          ],
          "must_not":[
            {
              "match":{
                "name":"erji"
              }
            }
          ]
        }
      }
    }
  }
}

# 搜索一台xiaomi nfc phone或者一台满足是一台手机,并且价格小于等于2999
GET /product/_search
{
    "query": {
        "constant_score": {
            "filter": {
                "bool": {
                    "should": [
                        {
                            "match_phrase": {
                                "name": "xiaomi nfc phone"
                            }
                        },
                        {
                            "bool": {
                                "must": [
                                    {
                                        "term": {
                                            "name": "phone"
                                        }
                                    },
                                    {
                                        "range": {
                                            "price": {
                                                "lte": 2999
                                            }
                                        }
                                    }
                                ]
                            }
                        }
                    ]
                }
            }
        }
    }
}

GET /product/_search
{
    "query": {
        "bool": {
            "filter": {
                "bool": {
                    "should": [
                        {
                            "range": {
                                "price": {
                                    "gte": 1999
                                }
                            }
                        },
                        {
                            "range": {
                                "price": {
                                    "gte": 3999
                                }
                            }
                        }
                    ]
                }
            }
        }
    }
}

# 查询结果高亮展示
GET /product/_search
{
  "query": {
    "match_phrase": {
      "name": "nfc phone"
    }
  },
  "highlight": {
    "fields": {
      "name":{}
    }
  }
}

# Scroll search
GET /product/_search?scroll=1m
{
  "query": {
    "match_all": {}
  },
  "sort": [
    {
      "price": "asc"
    }
  ],
  "size": 2
}


GET /_search/scroll
{
  "scroll":"1m",
  "scroll_id" : "FGluY2x1ZGVfY29udGV4dF91dWlkDXF1ZXJ5QW5kRmV0Y2gBFDN5RFppM1FCY0JXQ3h6aUVzMkNyAAAAAAAAH0MWVUpQMjN6VUFUUFNUQ1JnZl9XcXFsQQ=="
}

GET /product/_mapping/type
GET /product/_mapping

GET /product/_search


# 手工Mapping
PUT /product3
{
  "mappings": {
    "properties": {
      "date":{
        "type": "text"
      },
      "desc":{
        "type": "text",
        "analyzer": "english"
      },
      "name":{
        "type": "text",
        "index": false
      },
      "price":{
        "type": "long"
      },
      "tags":{
        "type": "text",
        "index": true
      },
      "parts":{
        "type": "object"
      },
      "partlist":{
        "type": "nested"
      }
    }
  }
}

GET /product3/_mapping
PUT /product3/_mapping
{
  "properties": {
    "name": {
      "type": "text",
      "fielddata": false
    }
  }
}

POST /product/_search
{
  "aggs":{
    "tag_agg_group":{
      "terms": {
        "field": "tags.keyword"
      }
    }
  }
}

# 统计价格大于1999的数据
GET /product/_search
{
  "query": {
    "bool": {
      "filter": [
        {
          "range": {
            "price": {
              "gt": 1999
            }
          }
        }
      ]
    }
  },
  "aggs": {
    "tag_agg_group": {
      "terms": {
        "field": "tags.keyword"
      }
    }
  },
  "size": 0
}

# 价格大于1999的每个tag产品的平均价格
GET /product/_search
{
  "aggs": {
    "avg": {
      "terms": {
        "field": "tags.keyword",
        "order": {
          "avg_price": "desc"
        }
      },
      "aggs": {
        "avg_price": {
          "avg": {
            "field": "price"
          }
        }
      }
    }
  },
  "size": 0
}

# 价格分组计算
GET /product/_search
{
  "aggs": {
    "tag_agg_group": {
      "range": {
        "field": "price",
        "ranges": [
          {
            "from": 100,
            "to": 1000
          },
          {
            "from": 1000,
            "to": 2000
          },
          {
            "from": 2000
          }
        ]
      },
      "aggs": {
        "price_agg": {
          "avg": {
            "field": "price"
          }
        }
      }
    }
  },
  "size": 0
}
```

![bideobbdhz](https://raw.githubusercontent.com/ryanzicky/images/main/20201214150927.jpeg)