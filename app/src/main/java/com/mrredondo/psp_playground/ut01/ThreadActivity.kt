package com.mrredondo.psp_playground.ut01

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mrredondo.psp_playground.R

/**
 * Activity para realizar ejercicios sobre hilos básicos vistos en la UT-01: Procesos e Hilos.
 *
 */
class ThreadActivity : AppCompatActivity() {

    inline val <reified T> T.TAG2: String
        get() = T::class.java.simpleName

    val TAG = ThreadActivity::class.simpleName
    lateinit var button: Button
    lateinit var label: TextView
    lateinit var spinner: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        setupView()
    }

    private fun setupView() {
        label = findViewById(R.id.label)
        button = findViewById(R.id.button)
        spinner = findViewById(R.id.spinner)
        button.setOnClickListener {
            //launchARN()
            //withThreadAndPost()
            //withRunUiThread()
            //withThread()
            //postDelayed()
            //launchProgressBar()
            //launchThreadFromParam()
            //launchMultipleThreads()
            launchMultipleInsideThreads()
            //testMyThread()
        }
    }

    private fun launchARN() {
        for (i in 1..100) {
            label.text = "Hola:{$i}"
            Thread.sleep(2000)
        }
    }

    private fun withThread() {
        Thread(Runnable {
            for (i in 1..100) {
                label.text = "Hola:{$i}"
                Thread.sleep(2000)
            }
        }).start()
    }

    private fun withThreadAndPost() {
        Thread(Runnable {
            for (i in 1..100) {
                label.post {
                    label.text = "Hola:{$i}"
                }
                Thread.sleep(2000)
            }
        }).start()
    }

    private fun withRunUiThread() {
        Thread(Runnable {
            for (i in 1..100) {
                runOnUiThread {
                    label.text = "Hola:$i"
                }
                Thread.sleep(2000)
            }
        }).start()
    }

    private fun launchThreadFromParam() {
        val thread = Thread(Runnable {
            for (i in 1..10) {
                Log.d(TAG, "Thread: $i")
                Thread.sleep(1000)
            }
        })
        thread.start()
    }

    private fun launchMultipleThreads() {
        val thread1 = Thread(Runnable {
            for (i in 1..10) {
                Log.d(TAG, "Hilo1: $i")
                Thread.sleep(2000)
            }
        })

        val thread2 = Thread(Runnable {
            for (i in 1..10) {
                Log.d(TAG, "Hilo2: $i")
                Thread.sleep(1000)
            }
        })

        val thread3 = Thread(Runnable {
            for (i in 1..10) {
                Log.d(TAG, "Hilo3: $i")
                Thread.sleep(1500)
            }
        })

        thread1.start()
        thread2.start()
        thread3.start()
    }

    private fun launchMultipleInsideThreads() {
        Thread(Runnable {
            Thread(Runnable {
                for (i in 1..10) {
                    Log.d(TAG, "Hilo2: $i")
                    Thread.sleep(1000)
                }
            }).start()
            for (i in 1..10) {
                Log.d(TAG, "Hilo1: $i")
                Thread.sleep(2000)
            }
        }).start()
    }

    private fun postDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            label.text = "Hola!!"
        }, 3000)
    }

    private fun launchProgressBar() {
        Thread(Runnable {
            for (i in 1..10) {
                runOnUiThread {
                    label.text = "Hola:$i"
                }
                Thread.sleep(1000)
            }
            runOnUiThread {
                spinner.visibility = View.VISIBLE
            }
            Handler(Looper.getMainLooper()).postDelayed({
                spinner.visibility = View.GONE
            }, 3000)
        }).start()
    }

    private fun testMyThread() {
        object : MyThread(this) {
            override fun doInWorkerThread() {
                for (i in 1..10) {
                    Log.d("@dev", "Contando: $i")
                    Thread.sleep(1000)
                }
            }

            override fun doInUiThread() {
                label.text = "He terminado!!"
            }

        }.run()
    }

    abstract class MyThread(private val activity: ThreadActivity) {
        fun run() {
            Thread(Runnable {
                doInWorkerThread()
                activity.runOnUiThread {
                    doInUiThread()
                }
            }).start()
        }

        abstract fun doInWorkerThread()
        abstract fun doInUiThread()
    }
}