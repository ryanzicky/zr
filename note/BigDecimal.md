### BigDecimal相关函数
**常用函数**
1. 加 add()
2. 减 subtract()
3. 乘 multiply()
4. 除 divide()
5. 绝对值 abs()
6. 取反数 negate()
7. 比较大小 compareTo()

**取舍规则**
1. 向正无穷方向舍入 ROUND_CEILING
2. 向零方向舍入 ROUND_DOWN 
3. 向负无穷方向舍入 ROUND_FLOOR 
4. 向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5   ROUND_HALF_DOWN 
5. 向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP，如果是偶数，使用ROUND_HALF_DOWN  ROUND_HALF_EVEN 
6. 向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6  ROUND_HALF_UP 
7. 计算结果是精确的，不需要舍入模式  ROUND_UNNECESSARY
8. 向远离0的方向舍入 ROUND_UP
