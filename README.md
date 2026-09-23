# search-engine

A search engine, built up module by module.

## Modules

| Module | Purpose |
|---|---|
| `indexer` | Document indexing. Currently MinHash for near-duplicate detection. |

## Build

```bash
./gradlew build
```

Build a single module:

```bash
./gradlew :indexer:build
```
