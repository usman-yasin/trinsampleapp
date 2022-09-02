package com.example.trinwizardapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.example.trinwizardapp.R
import com.example.trinwizardapp.data.model.ContactObj
import com.example.trinwizardapp.databinding.ItemContactBinding

class ContactAdapter(
    private val binding: androidx.databinding.DataBindingComponent,
    private val clickListener: (creditLimit: ContactObj) -> Unit
) : BaseListAdapter<ContactObj, ItemContactBinding>(
    diffCallback = DIFF_CALLBACK
) {
    override fun bind(
        binding: ItemContactBinding, item: ContactObj, position: Int
    ) {
//        binding.con = item
        binding.root.setOnClickListener {

        }
    }

    override fun createBinding(
        parent: ViewGroup,
        viewType: Int
    ): ItemContactBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_contact, parent, false, this.binding
        )
    }
}

private val DIFF_CALLBACK: DiffUtil.ItemCallback<ContactObj> =
    object : DiffUtil.ItemCallback<ContactObj>() {
        override fun areItemsTheSame(oldItem: ContactObj, newItem: ContactObj): Boolean {
            return oldItem.contactId == newItem.contactId
        }

        override fun areContentsTheSame(oldItem: ContactObj, newItem: ContactObj): Boolean {
            return oldItem.firstName == newItem.firstName
        }
    }