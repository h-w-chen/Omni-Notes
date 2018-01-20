mkdir x/
cp -r build/retrolambda/fossDebug/it/ x/
pushd x/
jar -cvf x.jar .
mkdir ./it/feio/android/omninotes/db/stubs/
popd

pushd ~/work/DCAP-Sapphire/generators/
java  -cp ~/work2/Omni-Notes/omniNotes/x/x.jar:/home/howell/Android/Sdk/platforms/android-23/android.jar:/home/howell/.gradle/caches/modules-2/files-2.1/com.github.federicoiosue/Omni-Notes-Commons/1.2.0/768611e74bfa00a99bda4f9faab961d9d436a905/Omni-Notes-Commons-1.2.0.jar:/home/howell/work/DCAP-Sapphire/sapphire/sapphire-core/build/libs/sapphire-core.jar:/home/howell/work/DCAP-Sapphire/sapphire/dependencies/apache.harmony/build/libs/apache.harmony.jar sapphire.compiler.StubGenerator /home/howell/work2/Omni-Notes/omniNotes/x/it/feio/android/omninotes/db/ it.feio.android.omninotes.db /home/howell/work2/Omni-Notes/omniNotes/x/it/feio/android/omninotes/db/stubs/

popd

cp -r x/it/feio/android/omninotes/db/stubs src/main/java/it/feio/android/omninotes/db/


