# إرشادات ربط Alpha Mail بـ Firebase

بما أنك قمت بتغيير معرف الحزمة إلى `com.core.alpha.mail` ، يجب عليك إنشاء مشروع جديد في Firebase لضمان عمل الإشعارات (Push Notifications).

## الخطوات:
1. اذهب إلى [Firebase Console](https://console.firebase.google.com/).
2. أنشئ مشروعاً جديداً باسم "Alpha Mail".
3. أضف تطبيق Android للمشروع واستخدم معرف الحزمة: `com.core.alpha.mail`.
4. قم بتحميل ملف `google-services.json`.
5. ضع الملف في المسار التالي داخل المشروع:
   `app-thunderbird/google-services.json`

## ملاحظة هامة:
تأكد من إضافة بصمة SHA-1 الخاصة بملف التوقيع (Keystore) الخاص بك في إعدادات تطبيق Firebase لضمان عمل ميزات مثل Google Sign-In إذا كنت تنوي تفعيلها.
