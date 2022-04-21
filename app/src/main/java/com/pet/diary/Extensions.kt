package com.pet.diary

import android.os.Bundle
import androidx.fragment.app.Fragment

fun <T : Fragment> T.withArguments(action: Bundle.() -> Unit): T {
    return apply {
        val args = Bundle().apply(action)
        arguments = args
    }
}

fun <T : Fragment> T.replaceFragment(fragment: Fragment, containerId: Int, tag: String) {
    childFragmentManager.beginTransaction()
        .replace(containerId, fragment, tag)
        .commit()
}

fun <T : Fragment> T.replaceFragmentParent(fragment: Fragment, containerId: Int, tag: String) {
    parentFragmentManager.beginTransaction()
        .replace(containerId, fragment, tag)
        .commit()
}

fun <T : Fragment> T.showFragment(fragment: Fragment, containerId: Int, tag: String) {
    val ft = childFragmentManager.beginTransaction()
    if (childFragmentManager.findFragmentByTag(tag)?.isAdded == true)
        ft.show(childFragmentManager.findFragmentByTag(tag)!!)
    else
        ft.add(containerId, fragment, tag)
    ft.commit()
}

fun <T : Fragment> T.showFragmentParent(fragment: Fragment, containerId: Int, tag: String) {
    val ft = childFragmentManager.beginTransaction()
    if (childFragmentManager.findFragmentByTag(tag)?.isAdded == true)
        ft.show(childFragmentManager.findFragmentByTag(tag)!!)
    else
        ft.add(containerId, fragment, tag)
    ft.commit()
}

fun <T : Fragment> T.hideFragment(tag: String) {
    val ft = childFragmentManager.beginTransaction()
    if (childFragmentManager.findFragmentByTag(tag)?.isAdded == true)
        ft.hide(childFragmentManager.findFragmentByTag(tag)!!)
    ft.commit()
}
