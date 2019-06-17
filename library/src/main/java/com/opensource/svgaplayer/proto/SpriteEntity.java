// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: svga.proto at 13:1
package com.opensource.svgaplayer.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

public final class SpriteEntity extends Message<SpriteEntity, SpriteEntity.Builder> {
  public static final ProtoAdapter<SpriteEntity> ADAPTER = new ProtoAdapter_SpriteEntity();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_IMAGEKEY = "";

  public static final String DEFAULT_MATTEKEY = "";

  /**
   * 元件所对应的位图键名, 如果 imageKey 含有 .vector 后缀，该 sprite 为矢量图层 含有 .matte 后缀，该 sprite 为遮罩图层。
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String imageKey;

  /**
   * 帧列表
   */
  @WireField(
      tag = 2,
      adapter = "com.opensource.svgaplayer.proto.FrameEntity#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<FrameEntity> frames;

  /**
   * 被遮罩图层的 matteKey 对应的是其遮罩图层的 imageKey.
   */
  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String matteKey;

  public SpriteEntity(String imageKey, List<FrameEntity> frames, String matteKey) {
    this(imageKey, frames, matteKey, ByteString.EMPTY);
  }

  public SpriteEntity(String imageKey, List<FrameEntity> frames, String matteKey, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.imageKey = imageKey;
    this.frames = Internal.immutableCopyOf("frames", frames);
    this.matteKey = matteKey;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.imageKey = imageKey;
    builder.frames = Internal.copyOf("frames", frames);
    builder.matteKey = matteKey;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof SpriteEntity)) return false;
    SpriteEntity o = (SpriteEntity) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(imageKey, o.imageKey)
        && frames.equals(o.frames)
        && Internal.equals(matteKey, o.matteKey);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (imageKey != null ? imageKey.hashCode() : 0);
      result = result * 37 + frames.hashCode();
      result = result * 37 + (matteKey != null ? matteKey.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (imageKey != null) builder.append(", imageKey=").append(imageKey);
    if (!frames.isEmpty()) builder.append(", frames=").append(frames);
    if (matteKey != null) builder.append(", matteKey=").append(matteKey);
    return builder.replace(0, 2, "SpriteEntity{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<SpriteEntity, Builder> {
    public String imageKey;

    public List<FrameEntity> frames;

    public String matteKey;

    public Builder() {
      frames = Internal.newMutableList();
    }

    /**
     * 元件所对应的位图键名, 如果 imageKey 含有 .vector 后缀，该 sprite 为矢量图层 含有 .matte 后缀，该 sprite 为遮罩图层。
     */
    public Builder imageKey(String imageKey) {
      this.imageKey = imageKey;
      return this;
    }

    /**
     * 帧列表
     */
    public Builder frames(List<FrameEntity> frames) {
      Internal.checkElementsNotNull(frames);
      this.frames = frames;
      return this;
    }

    /**
     * 被遮罩图层的 matteKey 对应的是其遮罩图层的 imageKey.
     */
    public Builder matteKey(String matteKey) {
      this.matteKey = matteKey;
      return this;
    }

    @Override
    public SpriteEntity build() {
      return new SpriteEntity(imageKey, frames, matteKey, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_SpriteEntity extends ProtoAdapter<SpriteEntity> {
    ProtoAdapter_SpriteEntity() {
      super(FieldEncoding.LENGTH_DELIMITED, SpriteEntity.class);
    }

    @Override
    public int encodedSize(SpriteEntity value) {
      return (value.imageKey != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.imageKey) : 0)
          + FrameEntity.ADAPTER.asRepeated().encodedSizeWithTag(2, value.frames)
          + (value.matteKey != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value.matteKey) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, SpriteEntity value) throws IOException {
      if (value.imageKey != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.imageKey);
      FrameEntity.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.frames);
      if (value.matteKey != null) ProtoAdapter.STRING.encodeWithTag(writer, 3, value.matteKey);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public SpriteEntity decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.imageKey(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.frames.add(FrameEntity.ADAPTER.decode(reader)); break;
          case 3: builder.matteKey(ProtoAdapter.STRING.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public SpriteEntity redact(SpriteEntity value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.frames, FrameEntity.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
