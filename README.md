# mybatis-h2-text-clob-fix
Demonstration of how to fix H2 / mybatis TEXT columns going into object with generic String (remove the `clob: ` prefix from values)

The problem is shown here: https://stackoverflow.com/questions/64019067/my-batis-custom-typehandler-does-not-work-properly?noredirect=1#comment113227261_64019067

The method `test_getIssueCountsWithDefaultMapper` throws an exception because
the fetched value is not a String (even though the Pair<String, Long> says it should
be).

The method `test_getIssueCounts` uses the correct method for H2 and TEXT columns.