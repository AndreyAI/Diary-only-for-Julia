package com.pet.diary.presentation.check

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pet.diary.R
import com.pet.diary.utils.autoCleared
import com.pet.diary.withArguments

class CheckerFragment: Fragment(R.layout.fragment_checker) {

    private var checkerAdapter: CheckerAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

//    private fun initList() {
//        checkerAdapter = UserListAdapter(::navigateToUserDetails, viewModel::removeUser)
//        with(userList) {
//            adapter = userAdapter
//            setHasFixedSize(true)
//        }
//    }
}