### Skip N lines

```
tail -n +<N + 1> <file>
```

`N` — number of lines to skip

Example: skipping CSV header
```shell
tail -n +2 file.csv
```