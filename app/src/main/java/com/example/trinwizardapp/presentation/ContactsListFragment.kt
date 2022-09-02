package com.example.trinwizardapp.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.trinwizardapp.R
import com.example.trinwizardapp.databinding.FragmentContactsBinding
import com.example.trinwizardapp.presentation.viewmodel.ContactsViewModel


class ContactsListFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (!this::binding.isInitialized) {
            binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_contacts, null, false
            )
        }
        displayDetails()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun displayDetails(){
        val contactsViewModel = ContactsViewModel(requireContext())
        contactsViewModel.getContactList()
        contactsViewModel.getContactListLiveData().observe(viewLifecycleOwner, Observer
        { contacts ->

        })
    }
}
