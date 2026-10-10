#### 0.5.10

- Support DataScript 1.x. DataScript 1.0.0 moved a connection's
  transaction listeners out of the connection's metadata and into the
  connection's inner state atom (`(:atom conn)`). `posh.plugin-base`
  now reads the listener registry from either location (see the new
  `conn-listeners` helper), so posh works with both the 0.18.x line and
  1.x. Verified against DataScript 1.8.1.
- The pull-analysis tests no longer assert a specific datom ordering,
  which is an artifact of DataScript's internal index iteration order
  and changed in 1.x.

#### 0.3.4

- Component-friendly: `posh!` now stores posh state inside the
  meta-data of the DataScript conn. There are now no global atoms and
  all is passed around in the conn.
- **Breaking change**: Removed `before-tx!`. You can bake up your own
  version of `transact!` in the rare case you need to add
  pre-transaction filters.
- New Feature: `active-queries` returns an atom that contains the set
  of all active queries for any rendered components. This info is
  helpful for syncing with the back-end.


