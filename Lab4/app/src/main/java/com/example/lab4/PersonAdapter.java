package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<Person> persons;

    public PersonAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Создание и настройка ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.nameTextView.setText(person.getName());
        holder.phoneNumberTextView.setText(person.getPhoneNumber());
        holder.emailTextView.setText(person.getEmail());
        holder.addressTextView.setText(person.getAddress());

        // Устанавливаем цвет фона для последнего TextView в каждом элементе списка
        if (person.isLastItem()) {
            String hexColor = person.getHexColor();
            if (hexColor != null && !hexColor.isEmpty()) {
                holder.colorTextView.setBackgroundColor(android.graphics.Color.parseColor(hexColor));
            } else {
                // Если цвет не указан, используем цвет по умолчанию
                holder.colorTextView.setBackgroundColor(android.graphics.Color.WHITE);
            }
        } else {
            // Для остальных элементов списка сбрасываем цвет фона в прозрачный
            holder.colorTextView.setBackgroundColor(android.graphics.Color.TRANSPARENT);
        }

        // Проверка, является ли текущий элемент последним
        if (position != getItemCount() - 1) {
            holder.itemView.setPadding(0, 0, 0, 16); // Добавляем отступ снизу
        } else {
            holder.itemView.setPadding(0, 0, 0, 0); // Убираем отступ для последнего элемента
        }
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    // ViewHolder для элемента списка
    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView phoneNumberTextView;
        public TextView emailTextView;
        public TextView addressTextView;
        public TextView colorTextView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneNumberTextView = itemView.findViewById(R.id.phoneNumberTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            colorTextView = itemView.findViewById(R.id.colorTextView);
        }
    }
}