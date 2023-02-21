package com.exe.paradox.Models;

public class Banner {
        public Banner() {
        }

        private String redirectUrl, id, imageUrl, text;


        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Banner(String id, String imageUrl, String redirectUrl, String text) {
            this.id = id;
            this.imageUrl = imageUrl;
            this.redirectUrl = redirectUrl;
            this.text = text;
        }
}
