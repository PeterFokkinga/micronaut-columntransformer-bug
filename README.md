Demonstration of a bug in the @ColumnTransformer annotation.

The @ColumnTransformer does not result in changes to the query when the entity is  loaded through a repository that has a `@Join` annotation, resulting in an error reading the data from the database into an entity object.

This is demonstrated by the `ReportRepositoryTest` class, note that `RiderRepositoryTest` does succeed.
