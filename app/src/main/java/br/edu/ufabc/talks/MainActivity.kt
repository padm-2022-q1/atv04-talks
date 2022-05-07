package br.edu.ufabc.talks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

/**
 * The main activity.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appBarConfiguration = AppBarConfiguration(getNavController().graph)
        setupActionBarWithNavController(getNavController(), appBarConfiguration)
    }

    private fun getNavHost() = supportFragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment

    private fun getNavController() = getNavHost().navController

    override fun onSupportNavigateUp(): Boolean {
        return getNavController().navigateUp() || super.onSupportNavigateUp()
    }
}
