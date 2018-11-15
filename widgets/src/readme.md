##TabHost
Call setup() before adding tabs if loading TabHost using findViewById().
However: You do not need to call setup() after getTabHost() in TabActivity

`but TabActivity class was deprecated in API level 13.
New applications should use Fragments instead of this class`

```
mTabHost = (TabHost)findViewById(R.id.tabhost);
mTabHost.setup();
mTabHost.addTab(TAB_TAG_1, "Hello, world!", "Tab 1");

```