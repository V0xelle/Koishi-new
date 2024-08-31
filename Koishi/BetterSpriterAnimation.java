/*    */ package Koishi;
/*    */ import basemod.animations.AbstractAnimation;
/*    */ import basemod.animations.SpriterAnimation;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*    */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*    */ import com.brashmonkey.spriter.Data;
/*    */ import com.brashmonkey.spriter.LibGdx.LibGdxDrawer;
/*    */ import com.brashmonkey.spriter.LibGdx.LibGdxLoader;
/*    */ import com.brashmonkey.spriter.Loader;
/*    */ import com.brashmonkey.spriter.Player;
/*    */ import com.brashmonkey.spriter.Point;
/*    */ import com.brashmonkey.spriter.SCMLReader;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ 
/*    */ public class BetterSpriterAnimation extends SpriterAnimation {
/*    */   public static boolean drawBones = false;
/* 21 */   private float frameRegulator = 0.0F; private static final float animFps = 0.016666668F;
/*    */   LibGdxLoader loader;
/*    */   LibGdxDrawer drawer;
/* 24 */   ShapeRenderer renderer = new ShapeRenderer();
/*    */   public Player myPlayer;
/*    */   
/*    */   public BetterSpriterAnimation(String filepath) {
/* 28 */     super(filepath);
/* 29 */     FileHandle handle = Gdx.files.internal(filepath);
/* 30 */     Data data = (new SCMLReader(handle.read())).getData();
/* 31 */     this.loader = new LibGdxLoader(data);
/* 32 */     this.loader.load(handle.file());
/* 33 */     this.drawer = new LibGdxDrawer((Loader)this.loader, this.renderer);
/* 34 */     this.myPlayer = new Player(data.getEntity(0));
/* 35 */     this.myPlayer.setScale(Settings.scale);
/*    */   }
/*    */   
/*    */   public AbstractAnimation.Type type() {
/* 39 */     return AbstractAnimation.Type.SPRITE;
/*    */   }
/*    */   
/*    */   public void setFlip(boolean horizontal, boolean vertical) {
/* 43 */     if ((horizontal && this.myPlayer.flippedX() > 0) || (!horizontal && this.myPlayer.flippedX() < 0)) {
/* 44 */       this.myPlayer.flipX();
/*    */     }
/*    */     
/* 47 */     if ((vertical && this.myPlayer.flippedY() > 0) || (!vertical && this.myPlayer.flippedY() < 0)) {
/* 48 */       this.myPlayer.flipY();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderSprite(SpriteBatch batch, float x, float y) {
/* 54 */     this.drawer.batch = batch;
/*    */     
/* 56 */     for (this.frameRegulator += Gdx.graphics.getDeltaTime(); this.frameRegulator - 0.016666668F >= 0.0F; this.frameRegulator -= 0.016666668F) {
/* 57 */       this.myPlayer.update();
/*    */     }
/*    */     
/* 60 */     AbstractPlayer player = AbstractDungeon.player;
/* 61 */     if (player != null) {
/* 62 */       this.myPlayer.setPosition(new Point(x, y));
/* 63 */       this.drawer.draw(this.myPlayer);
/* 64 */       if (drawBones) {
/* 65 */         batch.end();
/* 66 */         this.renderer.setAutoShapeType(true);
/* 67 */         this.renderer.begin();
/* 68 */         this.drawer.drawBoxes(this.myPlayer);
/* 69 */         this.drawer.drawBones(this.myPlayer);
/* 70 */         this.renderer.end();
/* 71 */         batch.begin();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/BetterSpriterAnimation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */