[`string_agg(expression, delimiter)`](https://www.postgresql.org/docs/9.0/functions-aggregate.html)

Aggregate into string like `'abc','def','ghi'`:
```
'''' || string_agg(<column>::text, ''',''') || ''''
```
