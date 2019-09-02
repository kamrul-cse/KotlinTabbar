# KotlinTabbar

This is just a simple template for Tabbar Fragment writen in Kotlin

Screenshots:

<img src="https://github.com/kamrul-cse/KotlinTabbar/blob/master/screenshots/home_fragment.png" width="200px" > <img src="https://github.com/kamrul-cse/KotlinTabbar/blob/master/screenshots/demo.gif" width="200px" >

`MainActivity.kt`

```kotlin
class MainActivity : AppCompatActivity(), HomeListener, HistoryListener, ProfileListener, SettingsListener {

    lateinit var toolbar: ActionBar

    var homeFragment = HomeFragment.newInstance()
    var historyFragment = HistoryFragment.newInstance()
    var profileFragment = ProfileFragment.newInstance()
    var settingsFragment = SettingsFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!

        homeFragment.mInterface = this
        historyFragment.mInterface = this
        profileFragment.mInterface = this
        settingsFragment.mInterface = this

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        openFragment(homeFragment)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                openFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                openFragment(historyFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                openFragment(settingsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    //HomeListener
    override fun homeLoaded() {
        toolbar.title = homeFragment.title
    }

    //HistoryListener
    override fun historyLoaded() {
        toolbar.title = historyFragment.title
    }

    //ProfileListener
    override fun profileLoaded() {
        toolbar.title = profileFragment.title
    }

    //SettingsListener
    override fun settingsLoaded() {
        toolbar.title = settingsFragment.title
    }
}
```

## Author
Md. Kamrul Hasan, mhgolap11@gmail.com
